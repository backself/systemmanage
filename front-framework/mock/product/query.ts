import { MockMethod } from 'vite-plugin-mock'

const data = {
	list:[
		{
			productId:1,//产品id
			productName:"a",//产品名称
			productRepertories:100,//产品库存
			productMatchType:1,//产品匹配模式
			productMathLevel:1,//产品匹配等级
			productStatus:1//产品上线状态
		}
	],
	pager:{
		page:1,
		pageSize:20,
		total:1
	}
}

export default [
  {
    url: `/mock/products/query`,
    method: 'post',
    response: ({ body }) => {
      const { page, pageSize } = body
      return {
        code: 200,
        data: data,
        msg: ''
      };
    }
  },
  {
    url: `/mock/products/add`,
    method: 'post',
    response: ({ body }) => {
      return {
        code: 200,
        data: {},
        msg: ''
      };
    }
  },
  {
    url: `/mock/products/update`,
    method: 'post',
    response: ({ body }) => {
		return {
        code: 200,
        data: {},
        msg: ''
      };
    }
  },
  {
    url: `/mock/products/del`,
    method: 'post',
    response: ({ body }) => {
      return {
        code: 200,
        data: {},
        msg: ''
      };
    }
  },
]