package com.epam.learnspring.service.impl;

import com.epam.learnspring.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class KirillUserImpl implements UserService {
    @Override
    public String getName() {
        return "Kirill";
    }
}
