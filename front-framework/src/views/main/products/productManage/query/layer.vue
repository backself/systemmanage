<template>
  <Layer :layer="layer" @confirm="submit" ref="layerDom">
    <el-form :model="form" :rules="rules" ref="ruleForm" label-width="120px" style="margin-right:30px;">
      <el-form-item label="产品名称：" prop="productName">
        <el-input v-model="form.productName" placeholder="请输入产品名称"></el-input>
      </el-form-item>
      <el-form-item label="产品库存：" prop="productRepertories">
        <el-input v-model="form.productRepertories" oninput="value=value.replace(/[^\d]/g,'')" placeholder="只能输入正整数"></el-input>
      </el-form-item>
	  <el-form-item label="产品状态:" prop="form.productStatus">
	  	<el-tooltip :content="form.productStatus == 1?'上线':'下线'" placement="top">
	  		  <el-switch
	  			v-model="form.productStatus"
	  			active-color="#13ce66"
	  			inactive-color="#ff4949"
	  			active-value="1"
	  			inactive-value="0">
	  		  </el-switch>
	  	  </el-tooltip>
	  </el-form-item>
	  
		<el-form-item label="匹配模式:" prop="form.productMatchType">
			<el-tooltip :content="form.productMatchType == 1?'精准匹配模式':'通用匹配模式'" placement="top">
				  <el-switch
					v-model="form.productMatchType"
					active-color="#13ce66"
					inactive-color="#ff4949"
					active-value="1"
					inactive-value="0">
				  </el-switch>
			  </el-tooltip>
		</el-form-item>
		<el-form-item label="匹配级别:" prop="form.productMathLevel">
			<el-input v-model="form.productMathLevel" placeholder="请输入匹配的最低级别"></el-input>
		</el-form-item>	
    </el-form>
  </Layer>
</template>

<script lang="ts">
import type { LayerType } from '@/components/layer/index.vue'
import type { Ref } from 'vue'
import type { ElFormItemContext } from 'element-plus/lib/el-form/src/token'
import { defineComponent, ref } from 'vue'
import { add, update } from '@/api/product/query'
import Layer from '@/components/layer/index.vue'
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
    const ruleForm: Ref<ElFormItemContext|null> = ref(null)
    const layerDom: Ref<LayerType|null> = ref(null)
    let form = ref({
      productId:"",//产品id
      productName:"",//产品名称
      productRepertories:"",//产品库存
      productMatchType:"",//产品匹配模式
      productMathLevel:"",//产品匹配等级
      productStatus:""//产品上线状态
    })
    const rules = {
      productName: [{ required: true, message: '请输入产品名称', trigger: 'blur' }],
      productRepertories: [{ required: true, message: '请输入数字', trigger: 'blur' }],
      productMathLevel: [{ required: true, message: '请输入数字', trigger: 'blur' }],
    }
    init()
    function init() { // 用于判断新增还是编辑功能
      if (props.layer.row) {
        form.value = JSON.parse(JSON.stringify(props.layer.row)) // 数量量少的直接使用这个转
		
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
            if (this.layer.row) {
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
        this.$emit('getTableData', true)
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
        this.$emit('getTableData', false)
        this.layerDom && this.layerDom.close()
      })
    }
  }
})
</script>

<style lang="scss" scoped>
  
</style>