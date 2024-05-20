package objektwerks

import com.typesafe.config.Config

import scalikejdbc.*

object Store:
  def apply(config: Config): Store = new Store(config)

final class Store(config: Config):
  val url = config.getString("db.url")
  val user = config.getString("db.user")
  val password = config.getString("db.password")

  ConnectionPool.singleton(url, user, password)

  def addTodo(todo: Todo): Todo =
    val id = DB localTx { implicit session =>
      sql"insert into todo(task) values(${todo.task})".updateAndReturnGeneratedKey().toInt
    }
    todo.copy(id = id)

  def updateTodo(todo: Todo): Boolean =
    DB localTx { implicit session =>
      sql"update todo set task = ${todo.task} where id = ${todo.id}".update()
    }
    true

  def listTodos(): Seq[Todo] =
    DB readOnly { implicit session =>
      sql"select * from todo"
        .map(rs => Todo( rs.int("id"), rs.string("task") ) )
        .list()
    }