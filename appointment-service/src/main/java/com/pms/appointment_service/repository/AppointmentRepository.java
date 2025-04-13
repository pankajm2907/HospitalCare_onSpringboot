package com.pms.appointment_service.repository;

import com.pms.appointment_service.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {


}
