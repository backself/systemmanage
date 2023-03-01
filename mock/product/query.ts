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
    url: `/mock/product/query/list`,
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
    url: `/mock/product/query/add`,
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
    url: `/mock/product/query/update`,
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
    url: `/mock/product/query/del`,
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