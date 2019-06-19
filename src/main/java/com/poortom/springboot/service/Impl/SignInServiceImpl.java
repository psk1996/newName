//package com.poortom.springboot.service.Impl;
//
//import com.iyundao.io.Service.IntegralService;
//import com.iyundao.io.Service.SignInService;
//import com.iyundao.io.mapper.*;
//import com.iyundao.io.model.*;
//import com.iyundao.io.tools.ResponseData;
//import org.apache.shiro.SecurityUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//@Service
//public class SignInServiceImpl implements SignInService {
//
//    @Autowired
//    private SignInMapper signInMapper;
//
//    @Autowired
//    private IntegralService integralService;
//
//    @Autowired
//    private ActivityJoinPeopleMapper joinPeopleMapper;
//
//    @Autowired
//    private ActivityModelMapper activityModelMapper;
//
//    @Autowired
//    private ActivityModelCustomMapper modelCustomMapper;
//
//    @Autowired
//    private PartyMemberCustomMapper memberCustomMapper;
//
//    /**
//     * @param list
//     * @param activityid
//     * @return
//     */
//    @Override
//    public ResponseData batchSignIn(List<Integer> list, Integer activityid) {
//        if (list.toString().equals("") || list.toString() == null) {
//            return new ResponseData(0, "传入数据为空");
//        } else {
//            try {
//                SysUserProvider sysUser = (SysUserProvider) SecurityUtils.getSubject().getPrincipal();
//                String flag = sysUser.getSysRole().getFlag();
//                PartyMember partyMember = memberCustomMapper.selectAllByPhone(sysUser.getPhone());
//                list.add(partyMember.getId());
//                if (flag.equals(2) || flag == "2") {
//                    Date date = new Date();
//                    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
//                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                    String s = format1.format(date);
//                    //获取允许签到的时间范围
//                    ActivityModel activityModel = modelCustomMapper.selectById(activityid);
//                    Date date1 = activityModel.getActivitysignstarttime();
//                    Date date2 = activityModel.getActivitysignendtime();
//
//                    if (date.getTime() > date1.getTime() && date.getTime() < date2.getTime()) {
//                        for (Integer integer : list) {
//
//                            SignIn signin = new SignIn();
//                            signin.setSignintime(date);
//                            signin.setActivityid(activityid);
//                            signin.setPartymemberid(integer);
//
//                            int i = signInMapper.insert(signin);
//                            if (i > 0) {
//
//                                //判断是否是第一次签到，如果第一次，实际参与人数+1
//                                Integer i2 = signInMapper.selectSum(signin);
//                                if (i2 == 1) {
//                                    ActivityModel activityModel1 = modelCustomMapper.selectById(signin.getActivityid());
//                                    Integer activityjoinnumber = activityModel1.getActivityjoinnumber() + 1;
//                                    modelCustomMapper.updateJoinNum(activityjoinnumber, signin.getActivityid());
//                                }
//
//                                //设置时间范围
//                                String s1 = s + " 00:00:00";
//                                String s2 = s + " 23:59:59";
//
//                                Date signintime = format.parse(s1);
//                                Date signintime1 = format.parse(s2);
//
//                                //查询当天签到次数
//                                int i1 = signInMapper.findnum(integer, activityid, signintime, signintime1);
//                                //如果签到次数只有一次，进行积分添加
//                                if (i1 < 2) {
//                                    IntegralRecord integralRecord = new IntegralRecord();
//                                    integralRecord.setPartymemberid(signin.getPartymemberid());
//                                    integralRecord.setActivityid(signin.getActivityid());
//                                    integralService.updateIntegralSum(integralRecord);
//                                }
//                            } else {
//                                return new ResponseData(0, "签到失败");
//                            }
//                        }
//                        return new ResponseData(200, "集体签到成功");
//                    } else {
//                        return new ResponseData(0, "未到签到时间");
//                    }
//                } else {
//                    return new ResponseData(0,"没有集体签到权限");
//                }
//
//            } catch (Exception e) {
//                e.printStackTrace();
//                return new ResponseData(0, e.getMessage());
//            }
//        }
//    }
//
//    /**
//     * 个人签到
//     *
//     * @param activityid
//     * 活动id
//     * @return
//     */
//    @Override
//    public ResponseData signIn(Integer activityid) {
//        SysUserProvider sysUser = (SysUserProvider) SecurityUtils.getSubject().getPrincipal();
//        PartyMember partyMember = memberCustomMapper.selectAllByPhone(sysUser.getPhone());
//        SignIn signIn = new SignIn();
//        signIn.setPartymemberid(partyMember.getId());
//        signIn.setActivityid(activityid);
//        if (signIn.toString().equals("") || signIn.toString() == null) {
//            return new ResponseData(0, "传入数据为空");
//        } else {
//
//            ActivityJoinPeople activityJoinPeople = new ActivityJoinPeople();
//            activityJoinPeople.setPartymemberid(signIn.getPartymemberid());
//            activityJoinPeople.setActivityid(signIn.getActivityid());
//            ActivityJoinPeople activityJoinPeople1 = joinPeopleMapper.selectByDoubleId(activityJoinPeople);
//            if (activityJoinPeople1.toString().equals("") || activityJoinPeople1.toString() == null) {
//                return new ResponseData(0, "不允许参加此活动");
//            } else {
//                Date date = new Date();
//                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                String s = simpleDateFormat.format(date);
//
//                //获取允许签到的时间范围
//                ActivityModel activityModel = modelCustomMapper.selectById(signIn.getActivityid());
//                Date date1 = activityModel.getActivitysignstarttime();
//                Date date2 = activityModel.getActivitysignendtime();
//
//                if (date.getTime() > date1.getTime() && date.getTime() < date2.getTime()) {//判断当前时间是否在允许的时间范围
//
//                    signIn.setSignintime(date);
//                    int i = signInMapper.insert(signIn);
//                    if (i > 0) {
//
//                        //判断是否是第一次签到，如果第一次，实际参与人数+1
//                        Integer i2 = signInMapper.selectSum(signIn);
//                        if (i2 == 1) {
//                            ActivityModel activityModel1 = modelCustomMapper.selectById(signIn.getActivityid());
//                            Integer activityjoinnumber = activityModel1.getActivityjoinnumber() + 1;
//                            modelCustomMapper.updateJoinNum(activityjoinnumber, signIn.getActivityid());
//                        }
//
//                        //设置时间范围
//                        String s1 = s + " 00:00:00";
//                        String s2 = s + " 23:59:59";
//                        Date signintime = null;
//                        Date signintime1 = null;
//                        try {
//                            signintime = format.parse(s1);
//                            signintime1 = format.parse(s2);
//                        } catch (ParseException e) {
//                            e.printStackTrace();
//                        }
//
//                        //查询当天签到次数
//                        int i1 = signInMapper.findnum(signIn.getPartymemberid(), signIn.getActivityid(), signintime, signintime1);
//                        //如果签到次数只有一次，进行积分添加
//                        if (i1 < 2) {
//                            IntegralRecord integralRecord = new IntegralRecord();
//                            integralRecord.setPartymemberid(signIn.getPartymemberid());
//                            integralRecord.setActivityid(signIn.getActivityid());
//                            return integralService.updateIntegralSum(integralRecord);
//                        } else {
//                            return new ResponseData(200, "签到成功");
//                        }
//                    } else {
//                        return new ResponseData(0, "签到失败");
//                    }
//                } else {
//                    return new ResponseData(0, "未到签到时间");
//                }
//            }
//        }
//    }
//
//}
