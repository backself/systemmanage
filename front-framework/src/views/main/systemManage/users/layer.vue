<template>
  <Layer :layer="layer" @confirm="submit">
    <el-form :model="ruleForm" :rules="rules" ref="form" label-width="120px" style="margin-right:30px;">
      <el-form-item label="用户名：" prop="name">
        <el-input v-model="ruleForm.userName" placeholder="请输入登录使用的用户名"></el-input>
      </el-form-item>
	  <el-form-item label="昵称：" prop="nickName">
	    <el-input v-model="ruleForm.nickName" placeholder="请输入昵称"></el-input>
	  </el-form-item>
	  <el-form-item label="密码：" prop="userPassword">
	    <el-input v-model="ruleForm.userPassword" placeholder="请输入密码"></el-input>
	  </el-form-item>
	  
	  <el-form-item prop="ruleForm.userStatus" label="状态" align="center">
	    <template #default="scope">
	      <span class="statusName">{{ ruleForm.userStatus === 1 ? "启用" : "禁用" }}</span>
	      <el-switch
	        v-model="ruleForm.userStatus"
	        active-color="#13ce66"
	        inactive-color="#ff4949"
	        :active-value="1"
	        :inactive-value="0"
	        :loading="ruleForm.loading"
	      ></el-switch>
	    </template>
	  </el-form-item>

		<el-form-item label="角色：" prop="roleId">
		  <el-select v-model="ruleForm.roleId" placeholder="请选择" clearable>
				<el-option
					v-for="item in options"
					:key="item.value"
					:label="item.label"
					:value="item.value">
				</el-option>
			</el-select>
		</el-form-item>

    </el-form>
  </Layer>
</template>

<script lang="ts">
import { defineComponent, ref, reactive } from 'vue'
import Layer from '@/components/layer/index.vue'
import { add, update } from '@/api/systemManagers/user'
export default defineComponent({
  components: {
    Layer
  },
  props: {
    layer: {
      type: Object,
      default: () => {
        return {
          show: false,
          title: '',
          showButton: true
        }
      }
    }
  },
  setup(props, ctx) {
	console.log("传入参数",props);
    let ruleForm = reactive({
		"userId": "",
		"userName": "",
		"nickName": "",
		"userStatus": 0,
		"roleId":1,
		"userPassword":""
    })
	
	if (props.layer.row) {
		ruleForm.userId = props.layer.row.id;
		ruleForm.userName = props.layer.row.userName;
		ruleForm.nickName = props.layer.row.nickName;
		ruleForm.roleId = props.layer.row.roleId;
		ruleForm.userStatus = props.layer.row.userStatus;
		ruleForm.userPassword = props.layer.row.userPassword;
	} 
	
    const rules = {
      userName: [{ required: true, message: '请输入姓名', trigger: 'blur' }],
      nickName: [{ required: true, message: '请输入昵称', trigger: 'blur' }],
      roleId: [{ required: true, message: '请选择用户角色', trigger: 'blur' }],
	  userPassword:[{ required: true, message: '请输入密码', trigger: 'blur' }]
    }

	const options =[
		{label:'工作人员',value:1},{label:'管理员',value:2}
	];

    return {
      ruleForm,
      rules,
	  options,
    }
  },
  methods: {
    submit() {
      this.$refs['form'].validate((valid: boolean) => {
        if (valid) {
          let params = this.ruleForm
          if (this.layer.row) {
			params.userId = this.layer.row.userId;
            this.updateForm(params)
          } else {
            this.addForm(params)
          }
        } else {
          return false;
        }
      });
    },
    // 新增提交事件
    addForm(params: object) {
      add(params)
      .then(res => {
        this.$message({
          type: 'success',
          message: '新增成功'
        })
        this.layer.show = false
        this.$emit('getTableData', true)
      })
    },
    // 编辑提交事件
    updateForm(params: object) {
      update(params)
      .then(res => {
        this.$message({
          type: 'success',
          message: '编辑成功'
        })
		this.layer.show = false
        this.$emit('getTableData', false)
      })
    }
  }
})
</script>

<style lang="scss" scoped>
  
</style>