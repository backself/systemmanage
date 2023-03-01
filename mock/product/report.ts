const data = {
	name:'2023年2月20日早7点至2023年2月21日早7点',
	list:[
		{"time":'7:00',"value":620},
		{"time":'8:00',"value":732},
		{"time":'9:00',"value":801},
		{"time":'10:00',"value":900},
		{"time":'11:00',"value":''},
		{"time":'12:00',"value":''},
		{"time":'13:00',"value":''},
		{"time":'14:00',"value":''},
		{"time":'15:00',"value":''},
		{"time":'16:00',"value":''},
		{"time":'17:00',"value":''},
		{"time":'18:00',"value":''},
		{"time":'19:00',"value":''},
		{"time":'20:00',"value":''},
		{"time":'21:00',"value":''},
		{"time":'22:00',"value":''},
		{"time":'23:00',"value":''},
		{"time":'24:00',"value":''},
		{"time":'01:00',"value":''},
		{"time":'02:00',"value":''},
		{"time":'03:00',"value":''},
		{"time":'04:00',"value":''},
		{"time":'05:00',"value":''},
		{"time":'06:00',"value":''},
		{"time":'07:00',"value":''},
	]
}

export default [
  {
    url: `/mock/product/report/get`,
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
]