package ge.vataga.tinder_job.repository;

import ge.vataga.tinder_job.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // Здесь вы можете добавить собственные методы для работы с пользователями, если это необходимо
}
