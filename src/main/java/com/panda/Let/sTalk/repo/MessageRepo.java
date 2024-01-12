package com.panda.Let.sTalk.repo;

import com.panda.Let.sTalk.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message,Long> {
}
