package com.brogrammers.sst.repos;

import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import com.brogrammers.sst.dto.SeatGeekEvent;


@Repository
public interface SeatGeekEventsRepo extends CouchbaseRepository<SeatGeekEvent, String> {
}
