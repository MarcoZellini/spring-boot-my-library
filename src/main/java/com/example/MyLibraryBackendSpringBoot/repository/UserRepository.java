package com.example.MyLibraryBackendSpringBoot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.MyLibraryBackendSpringBoot.model.User;

@Repository
public class UserRepository implements CrudRepository<User, Long> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User findByEmail(String email) {
        User result;
        String sql = "SELECT * FROM users WHERE email = ?";

        List<User> users = jdbcTemplate.query(sql,
                (rs, rowNum) -> {
                    return new User(rs.getLong("id"), rs.getString("name"), rs.getString("lastname"),
                            rs.getString("email"));
                },
                new Object[] { email });

        if (!users.isEmpty()) {
            result = users.get(0);

        } else {
            result = null;
        }

        return result;
    }

    @Override
    public void delete(@SuppressWarnings("null") User entity) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }

    @Override
    public void deleteAll(@SuppressWarnings("null") Iterable<? extends User> entities) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }

    @Override
    public void deleteAllById(@SuppressWarnings("null") Iterable<? extends Long> ids) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllById'");
    }

    @Override
    public void deleteById(@SuppressWarnings("null") Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public boolean existsById(@SuppressWarnings("null") Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'existsById'");
    }

    @SuppressWarnings("null")
    @Override
    public Iterable<User> findAll() {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @SuppressWarnings("null")
    @Override
    public Iterable<User> findAllById(Iterable<Long> ids) {
        throw new UnsupportedOperationException("Unimplemented method 'findAllById'");
    }

    @SuppressWarnings("null")
    @Override
    public Optional<User> findById(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends User> S save(@SuppressWarnings("null") S entity) {

        String sql = "INSERT INTO users (name, lastname, email, created_at, updated_at) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, entity.getName(), entity.getLastname(), entity.getEmail(), entity.getCreatedAt(),
                entity.getUpdatedAt());
        return entity;

        // super.save(entity)
        // throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @SuppressWarnings("null")
    @Override
    public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {
        throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

}