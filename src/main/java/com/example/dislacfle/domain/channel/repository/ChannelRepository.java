package com.example.dislacfle.domain.channel.repository;

import com.example.dislacfle.domain.channel.entity.Channel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepository extends JpaRepository<Channel, Long> {
    Optional<Channel> findByChannelName(String channelName);
}
