package com.example.CorrettoTest.Repository;

import com.example.CorrettoTest.Entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {
}
