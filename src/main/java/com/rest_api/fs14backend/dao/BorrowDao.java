package com.rest_api.fs14backend.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@Data
public class BorrowDao {
        private UUID bookId;
        private UUID userId;
        private Date borrowDate;
        private Date returnDate;
}
