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
    	// 1. 기본 for 문
//    	for(int i = 0; i < students.size(); i++) {
//    		if(students.get(i).getId() == id) {
//    			return students.get(i);
//    		}
//    	}
    	
    	// 2. 향상된 for 문
//    	for (변수타입 변수이름 : 배열이름){
//    		//반복할 코드
//    	}
    	
    	for (Student m : students) {
			if (id == m.getId()) {
				return m;
			}
		}
    	
    	
    	// 3. 람다식
    	// (매개변수) -> {본문}
//    	students.forEach((student) -> {
//    		if(student.getId() == id) {
//    			System.out.println(student.getId());
//    		}
//    	});
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
