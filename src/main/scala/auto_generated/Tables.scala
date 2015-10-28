package auto_generated
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.driver.MySQLDriver
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.driver.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Companies.schema ++ Computers.schema ++ Persons.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Companies
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(VARCHAR), Length(50,true) */
  case class Company(id: Int, name: String)
  /** GetResult implicit for fetching Company objects using plain SQL queries */
  implicit def GetResultCompany(implicit e0: GR[Int], e1: GR[String]): GR[Company] = GR{
    prs => import prs._
    Company.tupled((<<[Int], <<[String]))
  }
  /** Table description of table Companies. Objects of this class serve as prototypes for rows in queries. */
  class Companies(_tableTag: Tag) extends Table[Company](_tableTag, "Companies") {
    def * = (id, name) <> (Company.tupled, Company.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(name)).shaped.<>({r=>import r._; _1.map(_=> Company.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(VARCHAR), Length(50,true) */
    val name: Rep[String] = column[String]("name", O.Length(50,varying=true))
  }
  /** Collection-like TableQuery object for table Companies */
  lazy val Companies = new TableQuery(tag => new Companies(tag))

  /** Entity class storing rows of table Computers
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(VARCHAR), Length(40,true)
   *  @param introduced Database column introduced SqlType(DATE), Default(None)
   *  @param discontinued Database column discontinued SqlType(DATE), Default(None)
   *  @param companyid Database column companyId SqlType(INT), Default(None) */
  case class Computer(id: Int, name: String, introduced: Option[java.sql.Date] = None, discontinued: Option[java.sql.Date] = None, companyid: Option[Int] = None)
  /** GetResult implicit for fetching Computer objects using plain SQL queries */
  implicit def GetResultComputer(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[java.sql.Date]], e3: GR[Option[Int]]): GR[Computer] = GR{
    prs => import prs._
    Computer.tupled((<<[Int], <<[String], <<?[java.sql.Date], <<?[java.sql.Date], <<?[Int]))
  }
  /** Table description of table Computers. Objects of this class serve as prototypes for rows in queries. */
  class Computers(_tableTag: Tag) extends Table[Computer](_tableTag, "Computers") {
    def * = (id, name, introduced, discontinued, companyid) <> (Computer.tupled, Computer.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(name), introduced, discontinued, companyid).shaped.<>({r=>import r._; _1.map(_=> Computer.tupled((_1.get, _2.get, _3, _4, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(VARCHAR), Length(40,true) */
    val name: Rep[String] = column[String]("name", O.Length(40,varying=true))
    /** Database column introduced SqlType(DATE), Default(None) */
    val introduced: Rep[Option[java.sql.Date]] = column[Option[java.sql.Date]]("introduced", O.Default(None))
    /** Database column discontinued SqlType(DATE), Default(None) */
    val discontinued: Rep[Option[java.sql.Date]] = column[Option[java.sql.Date]]("discontinued", O.Default(None))
    /** Database column companyId SqlType(INT), Default(None) */
    val companyid: Rep[Option[Int]] = column[Option[Int]]("companyId", O.Default(None))

    /** Foreign key referencing Companies (database name Computers_ibfk_1) */
    lazy val companiesFk = foreignKey("Computers_ibfk_1", companyid, Companies)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Computers */
  lazy val Computers = new TableQuery(tag => new Computers(tag))

  /** Entity class storing rows of table Persons
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(VARCHAR), Length(50,true)
   *  @param address Database column address SqlType(VARCHAR), Length(250,true)
   *  @param companyid Database column companyId SqlType(INT), Default(None)
   *  @param computerid Database column computerId SqlType(INT), Default(None) */
  case class Person(id: Int, name: String, address: String, companyid: Option[Int] = None, computerid: Option[Int] = None)
  /** GetResult implicit for fetching Person objects using plain SQL queries */
  implicit def GetResultPerson(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[Int]]): GR[Person] = GR{
    prs => import prs._
    Person.tupled((<<[Int], <<[String], <<[String], <<?[Int], <<?[Int]))
  }
  /** Table description of table Persons. Objects of this class serve as prototypes for rows in queries. */
  class Persons(_tableTag: Tag) extends Table[Person](_tableTag, "Persons") {
    def * = (id, name, address, companyid, computerid) <> (Person.tupled, Person.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(name), Rep.Some(address), companyid, computerid).shaped.<>({r=>import r._; _1.map(_=> Person.tupled((_1.get, _2.get, _3.get, _4, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(VARCHAR), Length(50,true) */
    val name: Rep[String] = column[String]("name", O.Length(50,varying=true))
    /** Database column address SqlType(VARCHAR), Length(250,true) */
    val address: Rep[String] = column[String]("address", O.Length(250,varying=true))
    /** Database column companyId SqlType(INT), Default(None) */
    val companyid: Rep[Option[Int]] = column[Option[Int]]("companyId", O.Default(None))
    /** Database column computerId SqlType(INT), Default(None) */
    val computerid: Rep[Option[Int]] = column[Option[Int]]("computerId", O.Default(None))

    /** Foreign key referencing Companies (database name Persons_ibfk_1) */
    lazy val companiesFk = foreignKey("Persons_ibfk_1", companyid, Companies)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Computers (database name Persons_ibfk_2) */
    lazy val computersFk = foreignKey("Persons_ibfk_2", computerid, Computers)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Persons */
  lazy val Persons = new TableQuery(tag => new Persons(tag))
}
