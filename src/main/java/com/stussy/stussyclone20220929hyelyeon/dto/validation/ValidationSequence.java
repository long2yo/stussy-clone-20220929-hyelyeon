package com.stussy.stussyclone20220929hyelyeon.dto.validation;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({Default.class, ValidationGroups.NotBlankGroup.class, ValidationGroups.PatternCheckGroup.class})
public interface ValidationSequence {
}
