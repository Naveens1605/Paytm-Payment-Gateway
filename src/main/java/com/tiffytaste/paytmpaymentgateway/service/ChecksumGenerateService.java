package com.tiffytaste.paytmpaymentgateway.service;

import com.tiffytaste.paytmpaymentgateway.model.Body;
import com.tiffytaste.paytmpaymentgateway.repository.ChecksumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChecksumGenerateService {

    @Autowired
    ChecksumRepository checksumRepository;

    public String generateChecksum(Body body) {
        return checksumRepository.generateChecksum(body);
    }

    public boolean verifyChecksum(String response) {
        return checksumRepository.verifyChecksum(response);
    }
}
