<template>
	<view>
		<Tabs :tabs="tabs" @tabsItemChange="hanleTabsItemChange">
			<!-- 翻译 -->
			<block v-if="tabs[0].isActive">
				<el-card class="box-card" v-for="(item,index) in translate" :key="item.id">
					<navigator url="../translate/translate" @click="handleMessageT(item)">
						<view class="title">
							{{item.title}}
						</view>
						<view class="text">
						  {{item.chinese}}
						</view>
				  </navigator>
				</el-card>			
			</block>
			<!-- 作文 -->
			<block v-if="tabs[1].isActive">
				<el-card class="box-card" v-for="(item,index) in composition" :key="item.id">
					<navigator url="../composition_detil/index" @click="handleMessageC(item)">
						<view class="title">
							{{item.title}}
						</view>
						<view class="text">
						  {{item.chinese}}
						</view>
				  </navigator>
				</el-card>	
			</block>
			<!-- 文章 -->
			<block v-if="tabs[2].isActive">
				<el-card class="box-card" v-for="(item,index) in article" :key="item.id">
					<navigator url="../article/article" @click="handleMessageA(item)">
						<view class="title">
							{{item.title}}
						</view>
						<view class="text">
						  {{item.chinese}}
						</view>
				  </navigator>
				</el-card>	
			</block>
		
		</Tabs>
	</view>
</template>

<script>
	import Tabs from "../../components/Tabs.vue"
	export default {
		data() {
			return {
				tabs:[
					{
						id:0,
						value:"词组",
						isActive:true,
					},
					{
						id:1,
						value:"作文",
						isActive:false,
					},
					{
						id:2,
						value:"短文",
						isActive:false,
					},
					// {
					// 	id:3,
					// 	value:"六级作文",
					// 	isActive:false,
					// },
					// {
					// 	id:4,
					// 	value:"六级翻译",
					// 	isActive:false,
					// },
					// {
					// 	id:5,
					// 	value:"六级文章",
					// 	isActive:false,
					// },
					
				],
				translate:[],	//词组
				composition:[],	//作文
				article:[],		//短文
				TPageNum:1,
				CPageNum:1,
				APageNum:1,
			}
		},
		components:{
			Tabs
		},
		onLoad() {
			this.$request.get("/comp/getComp",{
				"type":"翻译",
				"pageNum":this.TPageNum
			}).then(res=>{
				this.translate=res.data;
			});
			this.$request.get("/comp/getComp",{
				"type":"作文",
				"pageNum":this.APageNum
			}).then(res=>{
				this.composition=res.data;
			});
			this.$request.get("/comp/getComp",{
				"type":"文章",
				"pageNum":this.CPageNum
			}).then(res=>{
				this.article=res.data;
			});
		},
		methods: {
			//激活tab
			hanleTabsItemChange(data){
				this.tabs.forEach((v,i)=>i===data?v.isActive=true:v.isActive=false);
			},
			//向子页面传值
			handleMessageT(item){
				//注意：如果用push则不能返回上一个页面
				this.$router.replace({
					path:"../translate/translate",
					query:{"translate":item}
				})
			},
			handleMessageC(item){
				//注意：如果用push则不能返回上一个页面
				this.$router.replace({
					path:"../composition_detil/index",
					query:{"composition":item}
				})
			},
			handleMessageA(item){
				//注意：如果用push则不能返回上一个页面
				this.$router.replace({
					path:"../article/article",
					query:{"article":item}
				})
			},
			//触底事件
			onReachBottom(){
				//翻译
				this.TPageNum=this.TPageNum+1;
				this.$request.get("/comp/getComp",{
					"type":"翻译",
					"pageNum":this.TPageNum
				}).then(res=>{
					// this.composition=res.data;
					this.translate.push(...res.data)
				});
				//作文
				this.CPageNum=this.CPageNum+1;
				this.$request.get("/comp/getComp",{
					"type":"作文",
					"pageNum":this.CPageNum
				}).then(res=>{
					this.composition.push(...res.data)
				});
				//文章
				this.APageNum=this.APageNum+1;
				this.$request.get("/comp/getComp",{
					"type":"文章",
					"pageNum":this.APageNum
				}).then(res=>{
					this.article.push(...res.data)
				});
			},
		}
	}
</script>

<style lang="less">	  
	page{
		background-color: #F1F1F1;
	}
  .box-card {
	width: 100%;
	margin: 10rpx;
	.title{
		margin-bottom: 20rpx;
		font-weight: bold;
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

</style>
