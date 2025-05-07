package dev.cbq.demo02.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@TableName("tb_permission")
public class Permission implements Serializable {

	private Long id;
	private String code;

}
