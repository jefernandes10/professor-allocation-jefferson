package com.project.professor.alocation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.professor.alocation.entity.Allocation;
import com.project.professor.alocation.repository.AllocationRepository;

@Service
public class AllocationService {

	private final AllocationRepository allocationRepository;
	private final ProfessorService professorService;
	private final CourseService courseService;

	public AllocationService(AllocationRepository allocationRepository, ProfessorService professorService,
			CourseService courseService) {
		super();
		this.allocationRepository = allocationRepository;
		this.professorService = professorService;
		this.courseService = courseService;
	}

	public List<Allocation> findAll() {
		List<Allocation> allocations = allocationRepository.findAll();
		return allocations;

	}

	public Allocation findById(Long id) {
		Optional<Allocation> opitional = allocationRepository.findById(id);
		Allocation allocation = opitional.orElse(null);
		return allocation;

	}

	public Allocation create(Allocation allocation) {

		allocation.setId(null);
		Allocation allocationNew = allocationRepository.save(allocation);
		return allocationNew;

	}

	public Allocation update(Allocation allocation) {
		Long id = allocation.getId();
		if (id != null && allocationRepository.existsById(id)) {

			Allocation allocationNew = allocationRepository.save(allocation);
			return allocationNew;
		} else {
			return null;
		}

	}

	public void deleteById(Long id) {
		if (allocationRepository.existsById(id)) {
			allocationRepository.deleteById(id);
		}
	}

public void deleteByAll()
{
	allocationRepository.deleteAllInBatch();
}


}

