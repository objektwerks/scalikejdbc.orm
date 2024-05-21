package objektwerks

import com.typesafe.config.Config

import scalikejdbc.*

final class Store(config: Config):
  val url = config.getString("db.url")
  val user = config.getString("db.user")
  val password = config.getString("db.password")

  ConnectionPool.singleton(url, user, password)

  val column = Todo.column

  def addTodo(todo: Todo): Todo =
    val id = Todo.createWithNamedValues(column.task -> todo.task)
    todo.copy(id = id)

  def updateTodo(todo: Todo): Boolean =
    val count = Todo.updateById(todo.id).withAttributes("task" -> todo.task)
    count > 0

  def listTodos(): Seq[Todo] = Todo.findAll()