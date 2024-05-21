package objektwerks

import scalikejdbc.{autoConstruct, ResultName, WrappedResultSet}
import scalikejdbc.orm.CRUDMapper

final case class Todo(id: Long = 0, task: String)

object Todo extends CRUDMapper[Todo]:
  override val tableName = "todo"
  override val defaultAlias = createAlias("todo")
  override def extract(wrappedResultSet: WrappedResultSet,
                       resultName: ResultName[Todo]): Todo = autoConstruct(wrappedResultSet, resultName)