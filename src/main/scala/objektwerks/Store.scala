package objektwerks

import com.typesafe.config.Config

import scalikejdbc.*

final class Store(config: Config):
  val url = config.getString("db.url")
  val user = config.getString("db.user")
  val password = config.getString("db.password")

  ConnectionPool.singleton(url, user, password)

  val column = Todo.column
  val task = column.columns(1).value

  def addTodo(todo: Todo): Todo =
    val id = Todo
      .createWithNamedValues(
        column.task -> todo.task
      )
    todo.copy(id = id)

  def updateTodo(todo: Todo): Int =
    Todo
      .updateById(todo.id)
      .withAttributes(
        task -> todo.task
      )

  def listTodos(): Seq[Todo] =
    Todo.findAll()