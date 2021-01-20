package com.algaworks.osworks.domain.service;

import java.time.OffsetDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.osworks.api.model.Comment;
import com.algaworks.osworks.domain.exception.BusinessException;
import com.algaworks.osworks.domain.exception.EntityNotFoundException;
import com.algaworks.osworks.domain.model.Client;
import com.algaworks.osworks.domain.model.ServiceOrder;
import com.algaworks.osworks.domain.model.StatusServiceOrder;
import com.algaworks.osworks.domain.repository.ClientRepository;
import com.algaworks.osworks.domain.repository.CommentRepository;
import com.algaworks.osworks.domain.repository.ServiceOrderRepository;

@Service
public class ManagementServiceOrderService {
	
	@Autowired
	private ServiceOrderRepository serviceOrderRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private CommentRepository commentRepository; 

	public ServiceOrder create(ServiceOrder serviceOrder) {
		Client client = clientRepository.findById(serviceOrder.getClient().getId())
				.orElseThrow(() -> new BusinessException("Client Not Found."));
		
		serviceOrder.setClient(client);
		serviceOrder.setStatus(StatusServiceOrder.OPEN);
		serviceOrder.setOpenDate(OffsetDateTime.now());
		
		return serviceOrderRepository.save(serviceOrder);
	}
	
	public void finish(Long serviceOrderId) {
		ServiceOrder serviceOrder = search(serviceOrderId);
		
		serviceOrder.finished();
		
		serviceOrderRepository.save(serviceOrder);
	}


	public Comment addComment(Long serviceOrderId, String description) {
		ServiceOrder serviceOrder = search(serviceOrderId);
		
		Comment comment = new Comment();
		comment.setShippingDate(OffsetDateTime.now());
		comment.setDescription(description);
		comment.setServiceOrder(serviceOrder);
		
		return commentRepository.save(comment);
	}

	private ServiceOrder search(Long serviceOrderId) {
		return serviceOrderRepository.findById(serviceOrderId)
				.orElseThrow(() -> new EntityNotFoundException("Service Order not found."));
	}

}