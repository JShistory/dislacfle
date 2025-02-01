package com.example.dislacfle.workSpace;

import com.example.dislacfle.domain.user.entity.User;
import com.example.dislacfle.domain.user.entity.UserRole;
import com.example.dislacfle.domain.user.repository.UserRepository;
import com.example.dislacfle.domain.workSpace.entity.WorkSpace;
import com.example.dislacfle.domain.workSpace.entity.dto.WorkSpaceDTO;
import com.example.dislacfle.domain.workSpace.repository.WorkSpaceRepository;
import com.example.dislacfle.domain.workSpace.service.WorkSpaceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Transactional
@SpringBootTest
public class WorkSpaceTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WorkSpaceRepository workSpaceRepository;

    @Autowired
    private WorkSpaceService workSpaceService;

    @Test
    public void 워크스페이스_생성_테스트() throws Exception {
        // given: 테스트 User 생성
        Long userId = createUser();
        WorkSpaceDTO workSpaceDTO = new WorkSpaceDTO();
        workSpaceDTO.setWorkSpaceName("테스트워크스페이스");
        workSpaceDTO.setUserId(userId);
        // when: WorkSpace 생성
        Long workSpaceId = workSpaceService.createWorkSpace(workSpaceDTO);

        // then: 생성된 WorkSpace 검증
        Optional<WorkSpace> savedWorkSpace = workSpaceRepository.findById(workSpaceId);

        // WorkSpace가 저장되었는지 확인
        assertEquals(savedWorkSpace.get().getSpaceName(), "테스트워크스페이스");
        assertEquals(savedWorkSpace.get().getChannels().get(0).getChannelName(), "Default Channel");
        System.out.println(savedWorkSpace.get().getUsers().get(0).getUser().getWorkSpaces().get(0).getWorkSpace().getSpaceName());
    }

    public Long createUser() {
        User user = User.builder()
                .username("test")
                .password("test")
                .nickname("test")
                .userRole(UserRole.USER)
                .build();
        userRepository.save(user);
        return user.getId();
    }
}
