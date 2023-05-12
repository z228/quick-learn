<template>
	<view>
		<view class="main">
			<view class="title">
				{{translate.title}}
			</view>
			
			<view class="chinese" >
				{{translate.chinese}}
			</view>
			<view class="showContent" @click="showContent()">
				<view class="textStyle">
					<view>点击空白处可显示翻译内容</view>
					<view class="el-icon-caret-bottom"></view>
				</view>
				<view class="english" :class="isActive ? 'active' : '' ">
					{{translate.english}}
				</view>
			</view>
			<view class="input">
				<textarea v-model="value1" placeholder="请输入内容"></textarea>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				isActive:true,
				translate:{},
				value1:""
			}
		},
		methods: {
			showContent(index){
				// this.isActive[index]=false;
				//如果用上面的方式，则页面不会马上响应
				this.isActive=!this.isActive;
			}
		},
		onLoad() {
			//接收上一个页面传来的参数
			var translate=this.$route.query.translate;
			this.translate=translate;
		
		},
	}
</script>

<style lang="less">
.main{
	padding: 20rpx;
	background-color: #F1F3F4;
	.title{
		font-size: 24px;
		font-weight: bold;
		text-align: center;
	}
	.chinese{
		font-family: 宋体;
		text-indent:2em;
		font-size: 16px;
	}
	.showContent{
		.english{
			font-family: Times New Roman;
			text-indent:2em;//首行缩进
			font-size: 16px;
			margin-bottom: 40rpx;
		}

		.textStyle{
			margin: 20rpx 0;
			text-align: center;
			font-size: 15px;
			color: #999;
		}
		.active{
			visibility: hidden;
		}
	}
	.input{
		background-color: #FFFFFF;
	}
	.foot_content{
	}
}

</style>
