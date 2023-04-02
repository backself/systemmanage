import option from './mockmodules/bar_chart'

/**
* 折线图数据链接
*/
export default [
  {
    url: `/mock/dashboard/report/get`,
    method: 'get',
    response: ({ body }) => {
      return {
        code: 200,
        data: option,
        msg: ''
      };
    }
  },
]