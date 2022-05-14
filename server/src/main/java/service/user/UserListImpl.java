package service.user;

import domain.CheckStatus;
import domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.UserRepository;
import repository.UserSearch;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserListImpl implements UserList{

    private final UserRepository userRepository;

    @Transactional
    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void modifyCheckSug(Long userIdx) {
        User findUser = userRepository.findOne(userIdx);
        findUser.setCheckSug(CheckStatus.CHECK);
    }

    @Transactional
    @Override
    public void modifyCheckSub(Long userIdx) {
        User findUser = userRepository.findOne(userIdx);
        findUser.setCheckSub(CheckStatus.CHECK);
    }

    @Override
    public List<User> findUserList() {
        return userRepository.findAll();
    }

    @Override
    public User findUser(Long userIdx) {
        return userRepository.findOne(userIdx);
    }

    @Override
    public List<User> findCheckUwUserList(UserSearch userSearch) {
        return userRepository.findCheckUwUserList(userSearch);
    }

    @Override
    public List<User> findDelinquentList() {
        return userRepository.findDelinquentList();
    }

    @Override
    public List<User> findMaturityUserList() {
        return userRepository.findMaturityUserList();

    }
}
