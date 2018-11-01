package cn.xupt.reward.framework.service;

import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import cn.xupt.reward.common.exception.UserPasswordNotMatchException;
import cn.xupt.reward.common.exception.UserPasswordRetryLimitExceedException;
import cn.xupt.reward.project.user.domain.User;



@Component
public class PasswordService
{


}
