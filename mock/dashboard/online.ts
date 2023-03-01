import list from './mockmodules/online'

/**
* 获取实时在线数据的链接
*/

export default [
	{
		url: `/mock/dashboard/online/list`,
		method: 'post',
		response: ({ body }) => {
			return {
			  code: 200,
			  data: list,
			  msg: ''
			};
		}
	},
]
