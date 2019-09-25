package com.person.repository;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.person.dto.OrganizationDTO;

@Repository
public class OrganizationRedisRepositoryImpl implements OrganizationRedisRepository {
    private static final String HASH_NAME ="organization";

    private RedisTemplate<String, OrganizationDTO> redisTemplate;
    private HashOperations<String, Integer, OrganizationDTO> hashOperations;

    public OrganizationRedisRepositoryImpl(){
        super();
    }

    @Autowired
    private OrganizationRedisRepositoryImpl(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }


    @Override
    public void saveOrganization(OrganizationDTO org) {
        hashOperations.put(HASH_NAME, org.getId(), org);
    }

    @Override
    public void updateOrganization(OrganizationDTO org) {
        hashOperations.put(HASH_NAME, org.getId(), org);
    }

    @Override
    public void deleteOrganization(int organizationId) {
        hashOperations.delete(HASH_NAME, organizationId);
    }

    @Override
    public OrganizationDTO findOrganization(int organizationId) {
       return (OrganizationDTO) hashOperations.get(HASH_NAME, organizationId);
    }
}
