<template>
  <Layer :layer="layer" @confirm="submit">
    <el-form :model="ruleForm" :rules="rules" ref="form" label-width="120px" style="margin-right:30px;">
      <el-form-item label="用户名：" prop="name">
        <el-input v-model="ruleForm.name" placeholder="请输入名称"></el-input>
      </el-form-item>
	  <el-form-item label="昵称：" prop="nickName">
	    <el-input v-model="ruleForm.name" placeholder="请输入名称"></el-input>
	  </el-form-item>
	  
	  <el-form-item prop="ruleForm.status" label="状态" align="center">
	    <template #default="scope">
	      <span class="statusName">{{ ruleForm.status === 1 ? "启用" : "禁用" }}</span>
	      <el-switch
	        v-model="ruleForm.status"
	        active-color="#13ce66"
	        inactive-color="#ff4949"
	        :active-value="1"
	        :inactive-value="0"
	        :loading="ruleForm.loading"
	      ></el-switch>
	    </template>
	  </el-form-item>

		<el-form-item label="角色类别：" prop="role">
		  <el-select v-model="ruleForm.role" placeholder="请选择" clearable>
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
import { add, update } from '@/api/table'
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
		id:'',
      name: '',
	  nickName:'',
	  role:'',
	  status:''
    })
	if (props.layer.row) {
		ruleForm.id = props.layer.row.id;
		ruleForm.name = props.layer.row.name;
		ruleForm.nickName = props.layer.row.nickName;
		ruleForm.role = props.layer.row.role;
		ruleForm.status = props.layer.row.status;
	} 
	
	
    const rules = {
      name: [{ required: true, message: '请输入姓名', trigger: 'blur' }],
      sort: [{ required: true, message: '请输入数字', trigger: 'blur' }],
      select: [{ required: true, message: '请选择', trigger: 'blur' }],
      radio: [{ required: true, message: '请选择', trigger: 'blur' }]
    }
    const options = [
      { value: '系统管理员', label: '系统管理员'},
      { value: '平台管理员', label: '平台管理员'},
      { value: '数据统计人员', label: '数据统计人员'},
      { value: "信息录入人员", label: '信息录入人员'},
    ]
    return {
      ruleForm,
      rules,
      options
    }
  },
  methods: {
    submit() {
      this.$refs['form'].validate((valid: boolean) => {
        if (valid) {
          let params = this.ruleForm
          if (this.layer.row) {
			params.id = this.layer.row.id;
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