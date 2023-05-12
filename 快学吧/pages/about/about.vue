<template>
	<view>
		<view class="top_content">
			<image src="../../static/logo.png"></image>
			<view class="version">快学吧 V0.1.32</view>
		</view>
		<view class="main_content">
			<text>
				本产品是一个关于四六级英语作文学习的平台，在这里您可以学到很多英语知识，希望对您有帮助，谢谢您的使用！
			</text>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			
		}
	}
</script>

<style lang="less" scoped>
	page{
		background-color: #F1F1F1;
	}
	.top_content{
		text-align: center;
		image{
			height: 150rpx;
			width: 150rpx;
			border-radius: 20%;
			margin: 50rpx 0 20rpx;
		}
		.version{
			margin-bottom: 20rpx;
			font-size: 14px;
			color: #606266;
		}
	}
	.main_content{
		color: #303133;
		margin: 0 40rpx;
		font-family: 思源黑体;
		text-indent:2em;
		font-size: 16px;
	}
</style>
