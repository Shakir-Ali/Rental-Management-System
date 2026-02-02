# RemindTenant

RemindTenant is an automated rental management backend application built to help property owners track rent and remind tenants to pay on time.

The idea for this project came from a real-life problem. My father manages rental properties and often needs to manually remind tenants to pay rent. Since this process is manual, reminders can sometimes be delayed or forgotten. RemindTenant automates this entire workflow.

## What RemindTenant Does

- Maintains tenant rent details such as starting rent, current rent, remaining balance, and payment status
- Keeps a complete transaction history for every rent-related activity
- Automatically adds rent on a fixed day of the month (1st or 15th)
- Automatically increases rent yearly by a configured percentage
- Sends WhatsApp reminders to tenants who have pending dues
- Runs fully in the background using scheduled jobs (cron)

## How It Works

The system uses scheduled tasks to:
- Check tenants with outstanding dues and send WhatsApp reminders
- Add monthly rent safely without duplication
- Apply yearly rent increments only once per year

All financial activities are recorded as transactions, while the tenant table stores only the current state.

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA / Hibernate
- PostgreSQL
- Spring Scheduler
- Twilio WhatsApp API
- Maven

## WhatsApp Integration

WhatsApp messaging is integrated using Twilio.  
A clean notification abstraction is used so messaging providers can be changed in the future without impacting business logic.

## Configuration

Twilio credentials are configured using environment variables:


## Purpose

This project is designed to solve a real-world problem by reducing manual follow-ups and ensuring rent reminders are never missed.

## Author

Shakir Ali
