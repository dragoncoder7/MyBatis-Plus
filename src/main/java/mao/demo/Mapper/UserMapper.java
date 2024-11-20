package mao.demo.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mao.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
