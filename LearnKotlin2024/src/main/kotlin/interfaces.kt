fun main() {
    // Cannot create an instance of an interface
    //val studentRepository = JpaRepository<Student, Long> //Interface JpaRepository does not have constructors

    val studentList = mutableListOf(
        Student("1", "John"),
        Student("2", "Jane"),
        Student("3", "Alice")
    )

    val studentRepository = object : StudentRepository {
        override fun findAll(): List<Student> = studentList

        override fun save(entity: Student): Student {
            studentList.add(entity)
            return entity
        }

        override fun delete(entity: Student) {
            studentList.remove(entity)
        }

        override fun findById(id: String): Student =
            studentList.find { it.id == id } ?: throw IllegalArgumentException("Student not found")

        override fun findByName(name: String): Student? =
            studentList.find { it.name == name } ?: null

    }

}

class StudentController(
    private val studentRepository: StudentRepository
) {
    fun saveStudent(student: Student): Student {
        return studentRepository.save(student)
    }

    fun deleteStudent(student: Student) {
        studentRepository.delete(student)
    }

    fun findStudentById(id: String): Student {
        return studentRepository.findById(id)
    }

    fun findStudentByName(name: String): Student {
        return studentRepository.findByName(name) ?: throw IllegalArgumentException("Student not found")
    }
}

interface JpaRepository<T, ID> {
    fun save(entity: T): T
    fun delete(entity: T)
    fun findById(id: ID): T
    fun findAll(): List<T>
}

interface StudentRepository : JpaRepository<Student, String> {
    fun findByName(name: String): Student?
}

