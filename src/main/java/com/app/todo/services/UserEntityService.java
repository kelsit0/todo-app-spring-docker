    package com.app.todo.services;

    import com.app.todo.dtos.TeacherDTO;
    import com.app.todo.dtos.UserDTO;
    import com.app.todo.persistence.entities.SubjectEntity;
    import com.app.todo.persistence.entities.UserEntity;
    import com.app.todo.persistence.repositories.SubjectEntityRepository;
    import com.app.todo.persistence.repositories.UserEntityRepository;
    import jakarta.persistence.*;
    import org.apache.catalina.User;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    import org.springframework.transaction.annotation.Transactional;

    import java.util.List;
    import java.util.stream.Collectors;

    @Service
    public class UserEntityService {

        @Autowired
        private UserEntityRepository userEntityRepository;
        @Autowired
        private SubjectEntityRepository subjectEntityRepository;

        @Transactional()
        public UserDTO addUser(UserEntity user){
            return userToDTO(userEntityRepository.save(user));
        }
        @Transactional(readOnly = true)
        public UserDTO getUserByUsername(String username){
            return userToDTO(userEntityRepository.findByUsername(username));
        }

        @Transactional(readOnly = true)
        public List<UserDTO> getUsers(){
            return userEntityRepository.findAll().stream()
                    .map(this::userToDTO)
                    .collect(Collectors.toList());
        }

        @Transactional()
        public void deleteUser(Long id){
            userEntityRepository.deleteById(id);
        }

        @Transactional()
        public UserDTO addSubject(Long userId, Long subjectId){
            UserEntity user= userEntityRepository.findById(userId).orElseThrow();
            SubjectEntity subject=subjectEntityRepository.findById(subjectId).orElseThrow();
            user.addSubject(subject);

            return userToDTO(userEntityRepository.save(user));
        }


        public UserDTO userToDTO(UserEntity user){
            if(user == null) return null;
            UserDTO userDTO = new UserDTO();

            userDTO.setId(user.getId());
            userDTO.setUsername(user.getUsername());
            userDTO.setEmail(user.getEmail());

            if(user.getTeacher()!=null){
                userDTO.setTeacher(
                        new TeacherDTO(
                                user.getTeacher().getId(),
                                user.getTeacher().getName(),
                                user.getTeacher().getEmail()
                        )
                );
            }

            if(user.getSubjects()!=null){
                userDTO.setSubjectIds(user.getSubjects().stream()
                        .map(subject ->subject.getId())
                        .collect(Collectors.toList()));
            }
            return userDTO;
        }

    }
