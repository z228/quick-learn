<template>
	<view>
		<form @submit="formSubmit">
			<view class="moudle">
				<view class="right_content">
					<view class="label_text">QK账号</view>
					<view name="" class="text">{{userInfo.nickname}}</view>
				</view>
			</view>
			<view class="moudle">
				<view class="right_content">
					<view class="label_text">手机号</view>
					<input name="phone" class="text" :value="userInfo.phone" />
				</view>
			   <view class="little_icon"> > </view>
			</view>
			<view class="moudle">
				<view class="right_content">
					<view class="label_text">QK密码</view>
					<input password="true" name="" class="text" :value="userInfo.password"/>
				</view>
			   <view class="little_icon"> > </view>
			</view>
			<!-- 提交数据 -->
			<view class="uni-btn-v">
				<button form-type="submit">提交</button>
			</view>
		</form>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				userInfo:{}
			}
		},
		onLoad(){
			var userinfo=uni.getStorageSync("userinfo");
			console.log(userinfo)
			this.userInfo=userinfo
		},
		methods: {
			formSubmit: function(e) {
				console.log('form发生了submit事件，携带数据为：' + JSON.stringify(e.detail.value))
				var formdata = e.detail.value
				uni.showModal({
					content: '提交成功',
					showCancel: false
				});
			},

		}
	}
</script>

<style lang="less" scoped>
	page{
		background-color: #F1F1F1;
	}
	.moudle{
		padding: 20rpx;
		margin: 2rpx 0;
		background-color: #FFFFFF;
		display: flex;
		justify-content: space-between;
		.right_content{
			display: flex;
			.label_text{
				color: #303133;
			}
			.text{
				margin-left: 50rpx;
				color: #909399;
			}
		}
		
		.little_title{
			font-size: 14px;
		}
	}
</style>
