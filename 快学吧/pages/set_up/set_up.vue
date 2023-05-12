<template>
	<view>
		<view class="main_content">
			<navigator url="../account_security/account_security" class="moudle">
				<view class="right_content">
					<view class="text">账号与安全</view>
				</view>
				<view class="little_icon"> > </view>
			</navigator>
			<navigator url="../message/message" class="moudle">
				<view class="right_content">
					<view class="text">消息通知</view>
				</view>
				<view class="little_icon"> > </view>
			</navigator>
			<navigator url="../about/about" class="moudle">
				<view class="right_content">
					<view class="text">关于快学吧</view>
				</view>
				<view class="little_icon"> > </view>
			</navigator>	
		</view>
		<view class="foot_content">
			<button class="btn" @click="logout">退出</button>
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
			logout(){
				uni.navigateTo({
					url:"../login/login"
				})
			}
		}
	}
</script>

<style lang="less" scoped>
	page{
		background-color: #F1F1F1;
	}
	.main_content{
		.moudle{
			background-color: #FFFFFF;
			display: flex;
			margin: 10rpx;
			padding: 20rpx;
			justify-content: space-between;
			.right_content{
				display: flex;
				.text{
				}
			}
			.little_icon{			
			}
			
		}		
	}
	.foot_content{
		margin-top: 20rpx;
		padding: 20rpx 0;
		background-color: #F1F1F1;
		.text{
			text-align: center;
		}
		margin: 20rpx 0;
		text-align: center;
		button{
			background-color: #409EFF;
			color: #FFFFFF;
			width: 40%;
		}
	}
</style>
