<template>
	<view>
		<form @submit="formSubmit" @reset="formReset">
		    <view class="moudle">
				<view class="right_content">
					<view class="label_text">账号</view>
					<input name="username" class="text" :value="userInfo.username" disabled="true"></input>
				</view>
		    </view>
			<view class="moudle">
				<view class="right_content">
					<view class="label_text">昵称</view>
					<input name="nickname" class="text" :value="userInfo.nickname"/>
				</view>
			   <view class="little_icon"> > </view>
			</view>
			<view class="moudle">
				<view class="right_content">
					<view class="label_text">性别</view>
					<radio-group name="sex" class="text">
						<label>
							<radio value="男" style="transform:scale(0.7)" /><text>男</text>
						</label>
						<label>
							<radio value="女" style="transform:scale(0.7)" /><text>女</text>
						</label>
						<label>
							<radio value="外星人" style="transform:scale(0.7)" checked /><text>外星人</text>
						</label>
					</radio-group>					
				</view>
			   <view class="little_icon"> > </view>
			</view>
			<view class="moudle">
				<view class="right_content">
					<view class="label_text">签名</view>
					<input name="description" class="text" :value="userInfo.description" />
				</view>
			   <view class="little_icon"> > </view>
			</view>
			<view class="moudle">
				<view class="right_content">
					<view class="label_text">邮箱</view>
					<input name="email" class="text" :value="userInfo.email" />
				</view>
			   <view class="little_icon"> > </view>
			</view>
			<view class="moudle">
				<view class="right_content">
					<view class="label_text">手机</view>
					<input name="phone" class="text" :value="userInfo.phone" />
				</view>
			   <view class="little_icon"> > </view>
			</view>
			<view class="uni-btn-v">
				<button form-type="submit">Submit</button>
				<button type="default" form-type="reset">Reset</button>
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
		methods: {
			formSubmit: function(e) {
				this.$request.get("/user/modUser",{
					"user":JSON.stringify(e.detail.value)
				}).then(res=>{
					console.log(res)
				})
				console.log('form发生了submit事件，携带数据为：' + JSON.stringify(e.detail.value))
				var formdata = e.detail.value
				uni.showModal({
					content: '提交成功',
					showCancel: false
				});
			},
			formReset: function(e) {
				console.log('清空数据')
			}
		},
		onLoad() {
			//接收上一个页面传来的参数
			var userInfo=this.$route.query.userInfo;
			this.userInfo=userInfo;
		},
	}
</script>

<style lang="less">
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
