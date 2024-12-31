import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    
	// 메모리 저장
	private final List<Student> students = new ArrayList<>();
	private int nextId = 1;
	
	public StudentRepositoryImpl() {
		System.out.println("StudentRepository 생성");
	}
	
	@Override
    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    @Override
    public Student findById(int id) {
    	for (Student m : students) {
			if (id == m.getId()) {
				return m;
			}
		}
    	
        return null;
    }

    @Override
    public void save(Student student) {
    	student = new Student(nextId++, student.getName(), student.getMajor());
    	students.add(student);
    }
   
    @Override
    public void update(int id, Student updatedStudent) {
        Student ToupdateId = findById(id);

        if (ToupdateId != null) {
        	ToupdateId.setName(updatedStudent.getName());
        	ToupdateId.setMajor(updatedStudent.getMajor());
        }
    }
    
    @Override
    public void delete(int id) {
    	Student ToRemoveId = findById(id);
    	students.remove(ToRemoveId);
    }
}
