import { MockMethod } from 'vite-plugin-mock'
const roles = ['系统管理员', '平台管理员', '数据统计人员', '信息录入人员', '普通人员']
export default [
  {
    url: `/mock/system/user/list`,
    method: 'post',
    response: ({ body }) => {
      const { page, pageSize } = body
      return {
        code: 200,
        data: {
          list: [{
			"id": 0,
			"name": "Sharon Jackson",
			"nickName": "赵丽",
			"status": 1,
			"role": roles[0],
			"isAdmin": 1
		}],
          pager: {
            page: page,
            pageSize: pageSize,
            total: 1
          }
        },
        msg: ''
      };
    }
  },
  {
    url: `/mock/system/user/add`,
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
    url: `/mock/system/user/update`,
    method: 'post',
    response: ({ body }) => {
      return {
        code: 401,
        data: {},
        msg: ''
      };
    }
  },
  {
    url: `/mock/system/user/updateStatus`,
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
    url: `/mock/system/user/del`,
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