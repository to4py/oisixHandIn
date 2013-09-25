//
//  Answer.h
//  BankerMatchCheker
//
//  Created by Yuki Toyoshima on 2013/07/29.
//  Copyright (c) 2013年 Yuki Toyoshima. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <CoreData/CoreData.h>


@interface Answer : NSManagedObject

@property (nonatomic, retain) NSString * answer;
@property (nonatomic, retain) NSNumber * answerID;
@property (nonatomic, retain) NSNumber * point;

@end
