package com.mahmoud.Accountingdemo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.stereotype.Service;

import com.mahmoud.Accountingdemo.service.AccountQueryService;


@Service
public class AccountQueryServiceImpl implements AccountQueryService {
	
	private final EventStore eventStore;

	public AccountQueryServiceImpl(EventStore eventStore) {
		super();
		this.eventStore = eventStore;
	}

	@Override
	public List<Object> listEventsforAccount(String AccountId) {
		// TODO Auto-generated method stub
		return eventStore.readEvents(AccountId).asStream().map(s -> s.getPayload()).collect(Collectors.toList());
	}

}
