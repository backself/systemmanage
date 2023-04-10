/**
 * 折柱混合图 option 默认的结构
 */
let defaultOption = {
  tooltip: {
    trigger: 'axis',
    // formatter: '{b}<br />{a2}:{c2}%<br />{a1}:{c1}%<br />{a0}:{c0}%'
    formatter: function (params, ticket, callback) {
      var htmlStr = '';
      for (var i = 0; i < params.length; i++) {
        var param = params[i];
        var xName = param.name;//x轴的名称
        var seriesName = param.seriesName;//图例名称
        var value = param.value;//y轴值
        var color = param.color;//图例颜色
        if (i === 0) {
          htmlStr += xName + '<br/>';//x轴的名称
        }
        htmlStr += '<div>';
        htmlStr += '<span style="margin-right:5px;display:inline-block;width:10px;height:10px;border-radius:5px;background-color:' + color + ';"></span>';//一个点
        htmlStr += seriesName + '：' + value + '万元';//圆点后面显示的文本
        htmlStr += '</div>';
      }
      return htmlStr;
    }
  },
  grid: {       //页边距
    top: '20%',
    left: '1%',
    right: '1%',
    bottom: '1%',
    containLabel: true
  },
  legend: {      // 图例
    top: '5%',
    // right:'20%',
    data: []
  },

  xAxis: {
    type: 'category',
    data: [],
    axisLine: {//坐标线
      lineStyle: {
        type: 'solid',
        color: '#E3E3E3', //轴线的颜色
        width: '2' //坐标线的宽度
      }
    },
    axisLabel: {
      formatter: '{value}',
    },
    textStyle: {
      fontSize: 12,
      fontFamily: 'PingFang SC',
      fontWeight: 400,
      lineHeight: 17,
      color: '#646464', //坐标值的具体的颜色
      opacity: 1,
    },
    axisTick: {
      show: false
    }
  },
  yAxis: {
    type: 'value',
    axisLine: {//线
      show: false
    },
    axisTick: {//刻度
      show: false
    },
    axisLabel: {
      formatter: '{value}',
    },
    textStyle: {
      fontSize: 12,
      fontFamily: 'PingFang SC',
      fontWeight: 400,
      lineHeight: 17,
      color: '#979A9F', //坐标值的具体的颜色
      opacity: 1,
    },
    splitLine: {
      lineStyle: {
        type: 'dashed',
        width: 2,
        color: ['#E3E3E3'] //分割线的颜色
        // color: ['#5d5d5d'] //分割线的颜色
      }
    }
  },
  series: [
    {
      type: 'bar',
      name: "",
      data: [],
      symbolSize: 9, //设置拐点大小
      itemStyle: {
        color: "#FFFFFF"
      },
      lineStyle: {
        width: 2,
        type: 'solid'  //'dotted'虚线 'solid'实线
      }
    }, {
      type: 'bar',
      name: "",
      data: [],
      symbolSize: 9, //设置拐点大小
      itemStyle: {
        color: "#FFFFFF"
      },
      lineStyle: {
        width: 2,
        type: 'solid'  //'dotted'虚线 'solid'实线
      }
    }, {
      type: 'line',
      name: '',
      data: [],
      symbolSize: 9, //设置拐点大小
      areaStyle: {
        color: {
          type: 'linear',
          x: 0,
          y: 0,
          x2: 0,
          y2: 1,
          colorStops: [{
            offset: 0, color: '#fe9d9a66' // 0% 处的颜色
          }, {
            offset: 1, color: '#fe9d9a00' // 100% 处的颜色
          }],
          global: false // 缺省为 false
        }
      },
      color: "#FFFFFF", //设置颜色
      lineStyle: {
        width: 2,
        type: 'solid'  //'dotted'虚线 'solid'实线
      }
    },
  ]
}


/**
 * 首页折柱混合图使用的option
 */
export default defaultOption;