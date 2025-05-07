package dev.cbq.demo02.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@TableName("tb_role")
public class Role implements Serializable {

	private Long id;
	private String code;

	@TableField(exist = false)
	private List<Permission> permissions;

}
