<template>
  <div class="wrapper">
    <h1 id=mytime>{{str}}</h1>
    <!-- <input id="mytime" type="text" name="" value="显示时间"> -->
    <button id="stop" name="button" @click="stop">stop</button>
    <button id="start" name="button" @click="start">start</button>
    <button id="reset" name="button" @click="reset">reset</button>
  </div>

</template>
<script>

export default {

  data () {
    return {
      s: 0,
      time: 0,
      str: '0'
    }
  },
  methods: {

    timer () { // 定义计时函数
      this.s = this.s + 1 // 秒
      this.str = this.s + ''/* +this.toDubms(this.ms)+"毫秒" */
    },

    reset () { // 重置
      clearInterval(this.time)
      this.s = 0
      this.str = '0'
    },

    start () { // 开始
      this.time = setInterval(this.timer, 1000)
    },

    stop () { // 暂停
      clearInterval(this.time)
    }
  },
  // 实例创建完成后调用，此阶段完成了数据的观测等，但尚未挂载，$el 还不可用。需要初始化处理一些数据时会比较有用
  created: function () {

  }

}
</script>
