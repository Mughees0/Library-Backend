package com.rest_api.fs14backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@Data
public class BorrowDto {
        private UUID bookId;
        private UUID userId;
}
