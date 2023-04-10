<template>
  <Layer :layer="layer" @confirm="submit" ref="layerDom">
    <el-form :model="form" :rules="rules" ref="ruleForm" label-width="120px" style="margin-right:30px;">
      <el-form-item label="链接名称：" prop="urlName">
        <el-input v-model="form.urlName" placeholder="请输入链接名称"></el-input>
      </el-form-item>
      <el-form-item label="链接类型：" prop="urlType">
		<el-tooltip :content="form.urlType == 0?'菜单':'链接'" placement="top">
      	  <el-switch
      		v-model="form.urlType"
      		active-color="#13ce66"
      		inactive-color="#ff4949"
      		active-value="0"
      		inactive-value="1">
      	  </el-switch>
        </el-tooltip>
	  </el-form-item>
	  <el-form-item label="链接内容：" prop="urlLink">
	    <el-input 
			type="textarea"
			:rows="2" 
			v-model="form.urlLink"
			 oninput="value=value.replace(/(A-Za-z)/g,'')" 
			 placeholder="只能输入大小写字母,.,:,''"
		></el-input>
	  </el-form-item>
	  <el-form-item label="链接状态:" prop="form.urlStatus">
	  	<el-tooltip :content="form.urlStatus == 0?'启用':'停用'" placement="top">
	  		  <el-switch
	  			v-model="form.urlStatus"
	  			active-color="#13ce66"
	  			inactive-color="#ff4949"
	  			active-value="0"
	  			inactive-value="1">
	  		  </el-switch>
	  	  </el-tooltip>
	  </el-form-item>
	  
		<el-form-item label="匹配模式:" prop="form.urlMatchType">
			<el-tooltip :content="form.urlMatchType == 1?'精准匹配模式':'通用匹配模式'" placement="top">
				  <el-switch
					v-model="form.urlMatchType"
					active-color="#13ce66"
					inactive-color="#ff4949"
					active-value="1"
					inactive-value="0">
				  </el-switch>
			  </el-tooltip>
		</el-form-item>
		<el-form-item label="通用匹配级别:" prop="form.urlCommonLevel">
			<el-input v-model="form.urlCommonLevel" placeholder="请输入匹配的最低级别"></el-input>
		</el-form-item>	
		<el-form-item label="精准匹配级别:" prop="form.urlSpecLevel">
			<el-input v-model="form.urlSpecLevel" placeholder="请输入匹配的准确级别"></el-input>
		</el-form-item>	
    </el-form>
  </Layer>
</template>

<script lang="ts">
import type { LayerType } from '@/components/layer/index.vue'
import type { Ref } from 'vue'
import type { ElFormItemContext } from 'element-plus/lib/el-form/src/token'
import { defineComponent, ref } from 'vue'
import { add, update } from '@/api/systemManagers/menu'
import Layer from '@/components/layer/index.vue'

import {url_form} from "./params"

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
		  url:{},
          showButton: true
        }
      }
    }
  },
  setup(props, ctx) {
    const ruleForm: Ref<ElFormItemContext|null> = ref(null)
    const layerDom: Ref<LayerType|null> = ref(null)
    let form = ref({})
	form.value = url_form;
    const rules = {
		urlName:[{ required: true, message: '请输入链接名称', trigger: 'blur' }],
		urlType:[{ required: true, message: '请输入数字', trigger: 'blur' }],
		urlLink:[{ required: true, message: '请输入正确内容', trigger: 'blur' }],
		urlStatus:[{ required: true, message: '请输入数字', trigger: 'blur' }],
		urlCommonLevel:[{ required: true, message: '请输入数字', trigger: 'blur' }],
		urlMatchType:[{ required: true, message: '请输入数字', trigger: 'blur' }],
		urlSpecLevel:[{ required: true, message: '请输入数字', trigger: 'blur' }]
	}
    init()
    function init() { // 用于判断新增还是编辑功能
      if (props.layer.url.urlId) {
        form.value = JSON.parse(JSON.stringify(props.layer.url)) // 数量量少的直接使用这个转
      } else {
		console.log(form.value)
      }
    }
    return {
      form,
      rules,
      layerDom,
      ruleForm,
    }
  },
  methods: {
    submit() {
      if (this.ruleForm) {
        this.ruleForm.validate((valid) => {
          if (valid) {
            let params = this.form
            if (this.layer.url.urlId) {
              this.updateForm(params)
            } else {
              this.addForm(params)
            }
          } else {
            return false;
          }
        });
      }
    },
    // 新增提交事件
    addForm(params: object) {
		console.log("提交表单数据",params);
      add(params)
      .then(res => {
        this.$message({
          type: 'success',
          message: '新增成功'
        })
        this.$emit('updateLinkListData', true)
        this.layerDom && this.layerDom.close()
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
        this.$emit('updateLinkListData', false)
        this.layerDom && this.layerDom.close()
      })
    }
  }
})
</script>

<style lang="scss" scoped>
  
</style>