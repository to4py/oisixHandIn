//
//  Person.m
//  PListSample
//
//  Created by 藤田 泰介 on 11/09/02.
//  Copyright (c) 2012年 Revolution 9. All rights reserved.
//

#import "Question.h"


@implementation Question

@synthesize question, answer1, answer3, answer2, qID;

- (id)initWithCoder:(NSCoder *)decoder
{
    self = [super init];
    if (self) {
        question = [decoder decodeObjectForKey:@"question"];
        answer1 = [decoder decodeObjectForKey:@"answer1"];
        answer2 = [decoder decodeObjectForKey:@"answer2"];
        answer3 = [decoder decodeObjectForKey:@"answer3"];
        qID = [decoder decodeObjectForKey:@"qID"];
      
    }
    return self;
}

- (void)encodeWithCoder:(NSCoder *)encoder
{
    [encoder encodeObject:question forKey:@"question"];
    [encoder encodeObject:answer1 forKey:@"answer1"];
    [encoder encodeObject:answer2 forKey:@"answer2"];
    [encoder encodeObject:answer3 forKey:@"answer3"];
    [encoder encodeObject:qID forKey:@"qID"];
    
}


-(NSString*)description{
    return [NSString stringWithFormat:@"<%@ :%p , question:%@, answer1:%@, answer2:%@, answer3:%@, qID:%@>",
            NSStringFromClass([self class]), self, question, answer1, answer2, qID];
}

@end
