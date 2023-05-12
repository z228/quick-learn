<template>
	<view>
		<view class="top_content">
			<image src="../../static/icon/sousuo.png"></image>
			<input class="search_input" placeholder="搜索标签" type="text" />
		</view>
		<view class="main_content">
			<el-card class="box-card" v-for="(item,index) in allNote" :key="item.nid">
				<view class="text">
					<view class="title_del">
						<view class="title">
							{{item.title}}
						</view>
						<image src="../../static/icon/shanchu1.png" @click="handleDel(item.nid)"></image>
					</view>
					<navigator url="../mod_note/mod_note" @click="handleMessageT(item.nid)">
					  {{item.content}}
					</navigator>
				</view>
			</el-card>			
		</view>
		<view class="foot_content_hidden">
			
		</view>
		<view class="foot_content">
			<image src="../../static/icon/tianjia.png" @click="handleTo"></image>
		</view>
	</view>
</template>

<script>

	export default {
		data() {
			return {
				allNote:[]
			}
		},
		components:{
			
		},
		onLoad() {
			this.$request.get("/note/getAllNote").then(res=>{
				this.allNote=res.data;
				console.log(res.data)
			});
		},
		methods: {
			//跳转到添加页面
			handleTo(){
				uni.navigateTo({
					url:"../make_note/make_note"
				})
			},
			//向子页面传值
			handleMessageT(nid){
				//注意：如果用push则不能返回上一个页面
				this.$router.replace({
					path:"../mod_note/mod_note",
					query:{"nid":nid}
				})
			},
			//删除元素
			handleDel(nid){
				var that=this;
				this.$request.get("/node/delnote",{
					"nid":nid
				}).then(res=>{
					uni.navigateTo({
						url:"../note/note"
					})
				})
			}
		}
	}
</script>

<style lang="less" scoped>	
	.top_content{
		margin: 20rpx;
		padding: 10rpx;
		display: flex;
		font-size: 14px;
		color: #5A5D5A;
		border: none;
		background-color: #FFFFFF;
		image{
			margin-right: 20rpx;
			height: 20px;
			width: 20px;
		}
	}
	.main_content{
		.box-card {
			width: 100%;
			margin: 10rpx;
			.title_del{
				display: flex;
				justify-content: space-between;
				.title{
					margin-bottom: 20rpx;
					font-weight: bold;
				}
				image{
					height: 55rpx;
					width: 55rpx;
				}
			}
			
			.text {
				color: #3F536E;
				font-size: 14px;
				display: -webkit-box;
				overflow: hidden;
				text-overflow: ellipsis;
				word-wrap: break-word;
				white-space: normal !important;
				-webkit-line-clamp: 2;
				-webkit-box-orient: vertical;
			}
		}
	}
	.foot_content_hidden{
		bottom: 0;
		height: 70px;
	}
	.foot_content{
		position: fixed;
		bottom: 0;
		width: 100%;
		image{
			margin: 0 43%;
			height: 70px;
			width: 70px;
		}
	}
	

</style>
